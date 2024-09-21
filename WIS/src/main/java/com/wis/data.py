import numpy as np
import json

def generate_jobs(num_jobs, mean_duration, std_duration, mean_weight, std_weight, mean_start, std_start):
    """ Generate job data based on specified statistical parameters. """
    jobs = []
    start_times = np.random.normal(mean_start, std_start, num_jobs)
    durations = np.abs(np.random.normal(mean_duration, std_duration, num_jobs))  # Ensure positive durations
    weights = np.abs(np.random.normal(mean_weight, std_weight, num_jobs))  # Ensure positive weights

    for i in range(num_jobs):
        start = max(int(start_times[i]), 0)  # Ensure non-negative start times
        duration = max(int(durations[i]), 1)  # Ensure a minimum duration of 1
        weight = max(int(weights[i]), 1)  # Ensure a minimum weight of 1
        end = start + duration
        jobs.append({
            "start": start,
            "end": end,
            "weight": weight
        })

    return jobs

def main():
    num_jobs = 10000  # Number of jobs to generate
    mean_duration = 5  # Average duration of jobs
    std_duration = 2  # Standard deviation of the job duration
    mean_weight = 10  # Average weight of jobs
    std_weight = 5  # Standard deviation of the job weight
    mean_start = 50  # Mean start time
    std_start = 15  # Standard deviation of start time

    jobs = generate_jobs(num_jobs, mean_duration, std_duration, mean_weight, std_weight, mean_start, std_start)
    
    # Save the job data to a JSON file
    with open('jobs_data.json', 'w') as f:
        json.dump(jobs, f, indent=4)

if __name__ == "__main__":
    main()
